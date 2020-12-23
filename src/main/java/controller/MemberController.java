package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.MemberBean;
import service.HomeService;
import service.MemberServiceInterface;

@SessionAttributes({"id", "name"})
@Controller
public class MemberController {

	@Autowired
	ServletContext context;
	
	@Autowired
	private MemberServiceInterface service;
	
	@Autowired
	HomeService hs;
	
//	@ModelAttribute("id")
//	public Integer id(HttpServletRequest request, HttpServletResponse response, Model model) {
//		return hs.cheakSessionId(response, request, (Integer)model.getAttribute("id"));
//	}

//	private Map<String, MemberBean> SessionId = new HashMap<String, MemberBean>();
	
	//會員登入
	@PostMapping("/login")
	public String login(Model model,
		@RequestParam("account") String account,
		@RequestParam("password") String password,
		HttpServletResponse response,
		HttpServletRequest request) {
		MemberBean mb=service.login(account, password);
		if(mb.getMemId() != null) {
			model.addAttribute("id", mb.getMemId());
			hs.addSession(request.getSession(true).getId(), mb);			
			Cookie sessionId = new Cookie("sessionId", request.getSession(true).getId());
			sessionId.setMaxAge(60*60*24*365);
			sessionId.setPath(request.getContextPath());
			response.addCookie(sessionId);
			return"Member/index";
		}else {
		model.addAttribute("msg","輸入錯誤請重新輸入");
		return"Member/loginPage";	
		}
	}
	//新增會員空白表單
	@GetMapping("/InsertMember")
	public String getinsertMember(Model model) {
		System.out.println("BBB");
	    MemberBean mb = new MemberBean();
	    model.addAttribute("MemberBean", mb); 
	    return "Member/InsertMember";
	}
	
//	@PostMapping("/insertSupportGame")
//	public String ImageUpload(@ModelAttribute("gamebean") GameBean gamebean,
//	Model model,
//	@RequestParam(value="file",required=false) CommonsMultipartFile file,
//	HttpServletRequest request,
//	RedirectAttributes attr
//	)throws Exception{
//	//---------注入資料
//	String name =UUID.randomUUID().toString().replaceAll("-", "");//使用UUID給圖片重新命名，並去掉四個“-”
//	String imageName=file.getOriginalFilename();//獲取圖片名稱
//	//String contentType=file.getContentType(); //獲得檔案型別（可以判斷如果不是圖片，禁止上傳）
//	//String suffixName=contentType.substring(contentType.indexOf("/")+1); 獲得檔案字尾名
//	String ext = FilenameUtils.getExtension(file.getOriginalFilename());//獲取檔案的副檔名
//	String filePath = "C:\\Users\\Student\\Desktop\\新增資料夾\\TableGame_new\\src\\main\\webapp\\resources\\images";//設定圖片上傳路徑
//	//System.out.println(filePath);
//	file.transferTo(new File(filePath+"/"+name + "." + ext));//把圖片儲存路徑儲存到資料庫
//	String image = "images/"+name + "." + ext;
//	//重定向到查詢所有使用者的Controller，測試圖片回顯
//	gamebean.setImage(image);
//	}
	
	//新增會員(註冊)
	@PostMapping("/InsertMember")
	public String processinsertMember(
			Model model,
			@ModelAttribute("MemberBean") MemberBean mb,
			@RequestParam(value="file",required=false) CommonsMultipartFile file,
			HttpServletRequest request,
			RedirectAttributes attr)throws Exception { 
	    
//		String name =UUID.randomUUID().toString().replaceAll("-", "");//使用UUID給圖片重新命名，並去掉四個“-”
		String name =mb.getMemAccount();//使用UUID給圖片重新命名，並去掉四個“-”
//		String imageName=file.getOriginalFilename();//獲取圖片名稱
		//String contentType=file.getContentType(); //獲得檔案型別（可以判斷如果不是圖片，禁止上傳）
		//String suffixName=contentType.substring(contentType.indexOf("/")+1); 獲得檔案字尾名
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());//獲取檔案的副檔名
//		String filePath =  (this.getClass().getClassLoader().getResource("/../../").getPath() + "memberImages").substring(1);//設定圖片上傳路徑
//		String filePath =  "C:\\Users\\Student\\Desktop\\新增資料夾\\TableGame_new\\src\\main\\webapp\\resources\\memberImages";//設定圖片上傳路徑
		String filePath = "C:/memberImages";//設定圖片上傳路徑
		File imagePath = new File(filePath);
		File fileImage = new File(filePath+"/"+name + ".jpg");
		if  (!imagePath .exists()  && !imagePath .isDirectory())      
		{ 
			imagePath .mkdir();    
		} 
		file.transferTo(fileImage);//把圖片儲存路徑儲存到資料庫
		//重定向到查詢所有使用者的Controller，測試圖片回顯
		mb.setMemPic("memberImages?img="+name + "." + ext);
		
		service.insertMember(mb);
		model.addAttribute("name", mb.getMemName());
		model.addAttribute("account", mb.getMemAccount());
//	    MultipartFile memImage = mb.getMemImage();
//		String originalFilename = memImage.getOriginalFilename();
//		mb.setMemfileName(originalFilename);
//		if (memImage != null && !memImage.isEmpty()) {
//			try {
//				byte[] b = memImage.getBytes();
//				Blob blob = new SerialBlob(b);
//				mb.setMemPic(blob);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//			}
//		}

//		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
//		String rootDirectory = context.getRealPath("/");
//		try {
//			File imageFolder = new File(rootDirectory, "images");
//			if (!imageFolder.exists())
//				imageFolder.mkdirs();
//			File file = new File(imageFolder, mb.getMemId() + ext); 
//			memImage.transferTo(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//		}
	    
	    return "Member/InsertMemberSuccess";
	}
	
	//會員清單
	@RequestMapping("/showMembers")
	public String list(Model model) {
		List<MemberBean> list = service.getAllMembers();
		model.addAttribute("allMembers",list);
	return "Member/showMembers";
	}
	
	//修改會員資料空白表單
	@GetMapping("/updateMember")
	public String getupdateMember(Model model,Integer id) {
	    MemberBean mb = service.getMember(id);
	    model.addAttribute("mb", mb); 
	    return "Member/updateMember";
	}
	
	//修改會員資料
	@PostMapping("/updateMember")
	public String processupdateMember(@ModelAttribute MemberBean mb,
			@RequestParam Integer memId) { 
//		System.out.println("123");
//		MultipartFile picture = mb.getMemImage();
//
//		if (picture.getSize() == 0) {
//			MemberBean original = service.getMember(memId);
//			mb.setMemPic(original.getMemPic());
//		} else {
//			String originalFilename = picture.getOriginalFilename();
//			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
//				mb.setMemfileName(originalFilename);
//			}
//			// 建立Blob物件
//			if (picture != null && !picture.isEmpty()) {
//				try {
//					byte[] b = picture.getBytes();
//					Blob blob = new SerialBlob(b);
//					mb.setMemPic(blob);
//				} catch (Exception e) {
//					e.printStackTrace();
//					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//				}
//			}
//		}		
		service.updateMember(mb);
	    return "redirect:/showMembers";
	}
	
	//刪除會員
	@GetMapping("/deleteMember")
	public String deleteMember(Integer id) { 
	    service.deleteMember(id);
	    return "redirect:/showMembers";
	}	
		
//	@GetMapping("/getPicture/{memId}")
//	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer memId) {
//		String filePath = "/resources/images/z.png";
//
//		byte[] media = null;
//		HttpHeaders headers = new HttpHeaders();
//		String filename = "";
//		int len = 0;
//		MemberBean bean = service.getMember(memId);
//		if (bean != null) {
//			Blob blob = bean.getMemPic();
//			filename = bean.getMemfileName();
//			if (blob != null) {
//				try {
//					len = (int) blob.length();
//					media = blob.getBytes(1, len); // 必須1開頭 而非0
//				} catch (SQLException e) {
//					throw new RuntimeException("Controller的getPicture()發生SQLException: " + e.getMessage());
//				}
//			} else {
//				media = toByteArray(filePath);
//				filename = filePath;
//			}
//		} else {
//			media = toByteArray(filePath);
//			filename = filePath;
//		}
//		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//		String mimeType = context.getMimeType(filename);
//		MediaType mediaType = MediaType.valueOf(mimeType); // image/jpeg
//		System.out.println("mediaType =" + mediaType);
//		headers.setContentType(mediaType);
//		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
//		return responseEntity;
//	}
//	
//	private byte[] toByteArray(String filepath) {
//		byte[] b = null;
//		String realPath = context.getRealPath(filepath);
//		try {
//			File file = new File(realPath);
//			long size = file.length();
//			b = new byte[(int) size];
//			InputStream fis = context.getResourceAsStream(filepath);
//			fis.read(b);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return b;
//	}
//
//	@InitBinder
//	public void whiteListing(WebDataBinder binder) {
//		binder.setAllowedFields("memImage");
//	}
	
}
