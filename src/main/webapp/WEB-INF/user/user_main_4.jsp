<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sorority_main</title>
<style type="text/css">
   /* main 슬라이드 css */
   #carouselExampleFade{
      margin-top: 200px;
      padding-right: 10vw;
      padding-left: 10vw; 
      height: 60vh;
   }
   
   .carousel-item img{ 
      height: 60vh;
      width:100%;
      text-align: center;
        
   } 
   
   .card_container{
      padding-right: 10vw;
      padding-left: 10vw;
   } 
   
   .card{
      margin-top: 50px;
      border: none;
   }
   
   #card_border{
   		border: none;
   		width: 90%;
   }
   
   .card img{
      transform: scale(1);
      -webkit-transform: scale(1);
      -moz-transform: scale(1);
      -ms-transform: scale(1);
      -o-transform: scale(1);
      transition: all 0.3s ease-in-out; 
   }
   
   .card img:hover{
      transform: scale(1.075);
      -webkit-transform: scale(1.075);
      -moz-transform: scale(1.075);
      -ms-transform: scale(1.075);
      -o-transform: scale(1.075);
      z-index: 99;
   }
   
   
   .main_img{
   	text-align: center;
   }
   
   
   .main_img img{
   		width: 100%;  
   		height: 480px;
   }
   .chips{
   	    content: "";
	    position: absolute;
	    margin-top : 40px;
	    left: 50%;
	    margin-left: -15px;
	    display: inline-block;
	    width: 30px;
	    height: 2px;
	    background: #ccc;    
   }
   h4{
   	position: relative;
    display: inline-block;
    font-size: 14px;
    font-weight: 700;
    text-align: center;
    letter-spacing: 1px;
   	
   }
</style>
</head>
<body>
   <%@include file="user_top_4.jsp" %>
   <!-- 메인 슬라이드 부분  -->
<div id="carouselExampleFade" class="c slide carousel-fade" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="http://app-storage-edge-005.cafe24.com/bannermanage2/sisshop/2020/10/07/d6c7f195631ae8da9bec439e29fc3a88.jpg" class="d-block w-12" alt="...">
    </div>
    <div class="carousel-item">
      <img src="http://app-storage-edge-005.cafe24.com/bannermanage2/sisshop/2020/10/07/646fbcf015ae1f89422c4099733b790a.jpg" class="d-block w-12" alt="...">
    </div>
    <div class="carousel-item">
      <img src="http://app-storage-edge-005.cafe24.com/bannermanage2/sisshop/2020/10/07/02cc898af0b2d92c2ab61dc8d1369244.jpg" class="d-block w-12" alt="...">
    </div>
  </div>
</div>
  <!-- 메인 슬라이드 끝  --> 
  
  
  <!-- 상품이미지 정보    차후에 div class="card" 영역하나로 데이터 베이스 접근하여 반복문으로 출력해야함 -->
  
  <div align="center" style="margin-top: 50px;">
     <h4>NEW ARRIVALS</h4>
     <span class="chips"></span>    
  </div>
  
  <section style="width: 100%; display: flex; flex-direction: column;">
  <section class="card_container" style="display: flex; flex-wrap: wrap; justify-content: center; width: 100%;">
  <c:forEach var="bean" items="${lists }" >
  <div class="card col-md-3 m3" id="card_border">
     <a class="main_img" href="detail.userdetail?pnum=${bean.pnum }">
        <img src="<%=request.getContextPath() %>/resources/${bean.pimage }" alt="..." >
     </a>
     <div class="card-body" align="left">
        <p>
           <b>item : ${bean.pname }</b><br>
           <b>price : ${bean.price }</b><br>
        </p>
     </div>
  </div>
  </c:forEach>

  </section>
  </section>
  





</body> 
</html>