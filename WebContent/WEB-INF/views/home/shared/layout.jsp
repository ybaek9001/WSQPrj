<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>layout</title>
<link href="${ctx}/content/css/style.css" type="text/css"
	rel="stylesheet" />
<style>
	    	* {
                margin: 0;
                padding: 0;
            }
            img {
            	
                border: 0;
            }
            ol, ul {
                list-style: none;
            }
            body {
                font-size: 12px;
                font-family: 돋움;
            }

            section.container {
                position: relative;
                width: 970px; 
                height: 300px;
                /* top: 100px; */
                margin: 0 auto;
                /* border: 10px solid #fff;
                box-shadow: 1px 1px 3px rgba(0,0,0,0.1); */
            }

            section ul.banner_mask {
                position: absolute;
                width: 970px; 
                height: 300px;
                overflow: hidden;
                /* background-size: cover; */
            }

            section ul.banner_mask li {
                position: absolute;
                top: 0px;
                left: 300px;
            }

            section.container label {
                float: left;
                position: relative;
                left: 210px;
                top: 5px;
                width: 16px;
                height: 16px;
                margin-left: 5px;
                background: #e0e0e0;
                line-height: 16px;
                text-align: center;
                cursor: pointer;
                z-index: 1000;
            }

            section.container input.banner_input1:checked ~ label.label_btn1,
            section.container input.banner_input2:checked ~ label.label_btn2,
            section.container input.banner_input3:checked ~ label.label_btn3,
            section.container input.banner_input4:checked ~
            label.label_btn4 {
                background: #0088cc;
                color: white;
            }

            section.container input {
                display: none;
            }

            section.container input.banner_input1:checked ~ .banner_mask li:nth-child(1),
            section.container input.banner_input2:checked ~ .banner_mask li:nth-child(2),
            section.container input.banner_input3:checked ~ .banner_mask li:nth-child(3),
            section.container input.banner_input4:checked ~
            .banner_mask li:nth-child(4) {
                -webkit-animation: none;
                -webkit-transition: left 0.5s ease-in-out;
                left: 0px;
                z-index: 10;
            }

            section.container input:checked ~
            .banner_mask li {
                -webkit-animation: slideOut 0.5s ease-in-out none;
            }

            @-webkit-keyframes slideOut{
            0%{ left: 0px; }
            100%{ left: -300px; }
            }

</style>
</head>

<body>
	<header id="header">
	<div class="content-container">
		<!-- header 부분 -->
		<tiles:insertAttribute name="header" />
	</div>
	</header>
	<div id="visual">
		<section class="container">
            <input id="select1" name="radioBanner" type="radio" class="banner_input1" checked="" />
            <label for="select1" class="label_btn1">1</label>
            <input id="select2" name="radioBanner" type="radio" class="banner_input2" />
            <label for="select2" class="label_btn2">2</label>
            <input id="select3" name="radioBanner" type="radio" class="banner_input3" />
            <label for="select3" class="label_btn3">3</label>
            <input id="select4" name="radioBanner" type="radio" class="banner_input4" />
            <label for="select4" class="label_btn4">4</label>
            <ul class="banner_mask">
                <li>
                    <a href="#none"><img src="/WSQPrj/content/images/bg.png" alt="첫번째 배너이미지" /></a>
                    <a href="#none"><img src="/WSQPrj/content/images/chat.png" alt="두번째 배너이미지" /></a>
                </li>
                <li>
                    <a href="#none"><img src="/WSQPrj/content/images/test2.jpg" alt="두번째 배너이미지" /></a>
                </li>
                <li>
                    <a href="#none"><img src="/WSQPrj/content/images/test4.jpg" alt="세번재 배너이미지" /></a>
                </li>
                <li>
                    <a href="#none"><img src="/WSQPrj/content/images/test3.jpg" alt="네번째 배너이미지" /></a>
                </li>
            </ul>
        </section>	
	</div>

	<div id="body">
		<div class="content-container clearfix">
			<!-- notice 컨텐츠 들어가는 부분 -->
			<tiles:insertAttribute name="content" />
		</div>
	</div>


	<footer id="footer">
	<div class="content-container">
		<!-- footer 들어가는 부분 -->
		<tiles:insertAttribute name="footer" />
	</div>
	</footer>

</body>
</html>