<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head lang="en">
        <meta charset="UTF-8">
<!--         <script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script> -->
        <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    </head>

    <body>
    	<div style="width:390px;">
	    	<div style="width:40px; height:40px; float:right">
		        <button type="button" class="close" aria-label="Close" style="width:40px; height:40px; background:red;opacity: 0.3;">
				  <span>&times;</span>
				</button>
	    	</div>
	        <div id="tou" style="font-size:30px">
	        </div>
	        <hr style="margin-top:5px">
	    </div>
        <div id="msg" style="width:380px; height:330px; overflow-y:auto; word-wrap:break-word; word-break:break-all;"></div>
        <hr style="margin-top:3px; margin-bottom:3px">
           <div style="width:390px;">
               <textarea placeholder="傳送資訊..." id="message" style="font-size:30px; width:330px; height:80px" cols="5"></textarea><button type="button" id="send" style="font-size:30px; float:right; width:50px; margin-right:3px">傳送</button>
           </div>
    </body>

</html>