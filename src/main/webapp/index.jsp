<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@taglib uri = "http://www.springframework.org/tags/form" prefix="mvc" %>
   <%@ page isELIgnored="false" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dijkstra's Dry Goods Ordering Page</title>
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
<style>
    	#visible{
    		color:white;
    		font-weight:900;
			text-shadow: 0px 0px 3px #000;
			text-shadow: 0px 0px 3px #000, -1px -1px #000, 1px 1px #000;
    	}
        *{
            font-family: 'Quicksand', sans-serif;
            
        }
        .hero-image {
            background-image: url("images/pcb.jpg");
            background-color: #cccccc;
            height: 1500px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }

        .hero-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }
        ul {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        form {
            color:black;
            text-shadow:
                    -1px -1px 0 white,
                    1px -1px 0 white,
                    -1px 1px 0 white,
                    1px 1px 0 white;
            margin: 0 auto;
            width: 400px;
            padding: 1em;
            border: 1px solid #CCC;
            border-radius: 1em;
        }

        div+div {
            margin-top: 1em;
        }

        label span {

            display: inline-block;
            width: 150px;
            text-align: right;
        }

        input, textarea {
            font: 1em sans-serif;
            width: 150px;
            box-sizing: border-box;
            border: 1px solid #999;
        }

        input[type=checkbox], input[type=radio] {
            width: auto;
            border: none;
        }

        input:focus, textarea:focus {
            border-color: #000;
        }

        textarea {
            vertical-align: top;
            height: 5em;
            resize: vertical;
        }

        fieldset {
            width: 250px;
            box-sizing: border-box;
            margin-left: 136px;
            border: 1px solid #999;
        }

        button {
            margin: 20px 0 0 124px;
        }

        label {
            position: relative;
        }

        label em {
            position: absolute;
            right: 5px;
            top: 20px;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 24px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
            border-radius:12px;
        }
        .button1 {
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
            border-radius:12px;

        }

        .button1:hover {
            background-color: #4CAF50;
            color: white;
            border-radius:12px;

        }
        .button1:active{
            background-color: #2f8432;
            outline:none;
            box-shadow: inset 0px 0px 5px #c1c1c1;
            


        }
        button:focus {outline:0;}
        input[type=radio] {
		display:none;
	}

	input[type=radio] + label {
		display:block;
		margin:-2px;
		padding: 4px 12px;
		margin-bottom: 0;
		font-size: 14px;
		line-height: 20px;
		color: #333;
		text-align: center;
		text-shadow: 0 1px 1px rgba(255,255,255,0.75);
		vertical-align: middle;
		cursor: pointer;
		background-color: #f5f5f5;
		background-image: -moz-linear-gradient(top,#fff,#e6e6e6);
		background-image: -webkit-gradient(linear,0 0,0 100%,from(#fff),to(#e6e6e6));
		background-image: -webkit-linear-gradient(top,#fff,#e6e6e6);
		background-image: -o-linear-gradient(top,#fff,#e6e6e6);
		background-image: linear-gradient(to bottom,#fff,#e6e6e6);
		background-repeat: repeat-x;
		border: 1px solid #ccc;
		border-color: #e6e6e6 #e6e6e6 #bfbfbf;
		border-color: rgba(0,0,0,0.1) rgba(0,0,0,0.1) rgba(0,0,0,0.25);
		border-bottom-color: #b3b3b3;
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff',endColorstr='#ffe6e6e6',GradientType=0);
		filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
		-webkit-box-shadow: inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
		-moz-box-shadow: inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
		box-shadow: inset 0 1px 0 rgba(255,255,255,0.2),0 1px 2px rgba(0,0,0,0.05);
	}

	input[type=radio]:checked + label {
		   background-image: none;
		outline: 0;
		-webkit-box-shadow: inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);
		-moz-box-shadow: inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);
		box-shadow: inset 0 2px 4px rgba(0,0,0,0.15),0 1px 2px rgba(0,0,0,0.05);
			background-color:#e0e0e0;
	}
	a:link, a:visited {
  background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 24px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
            border-radius:12px;
             background-color: white;
            color: black;
            border: 2px solid #4CAF50;
            border-radius:12px;
}

a:hover{
  background-color: #4CAF50;
            color: white;
            border-radius:12px;
}
a:active {
background-color: #2f8432;
            outline:none;
            box-shadow: inset 0px 0px 5px #c1c1c1;
}
    </style>
    </head>
    <body><div class="hero-image">
     <div class="hero-text">
        <h1 style="font-size:50px">DIJKSTRA'S DRY GOODS</h1>
        <h3>PREMIER SHIPPING AND LOGISTICS</h3>
    <a href="formOrder.mvc">Order Form</a>
<a href="trackOrder.mvc">Order Tracking</a>
<a href="serviceSide.mvc">Service Entry</a>
    </div>
    </div></body>
