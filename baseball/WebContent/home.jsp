<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>kbo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>



<div class="container">
<div class = "row">
<!-- 팀목록  -->
<div class = "col-sm-3">
  <table class="table table-dark table-striped">
  <h3>팀목록</h3>
    <thead>
      <tr>
        <th>순위</th>
        <th>팀이름</th>
      </tr>
    </thead>
<tbody id = "my__tbody">
<c:forEach var="team" items="${teams}">
      <tr>
        <td>${team.lank}</td>
        <td style = "cursor:pointer" onclick="playerList('${team.teamName}')" > ${team.teamName} </td>
      </tr>
</c:forEach>
 </tbody>
  </table>
  </div>
  
  <!-- 선수 목록 -->
  <div class = "col-sm-4">
    <table class="table table-dark table-striped">
  <h3>선수목록</h3>
    <thead>
      <tr>
        <th>NO.</th>
        <th>이름</th>
      </tr>
    </thead>
<tbody id = "player__List">
<c:forEach var="player" items="${players}">
      <tr>
        <td>${player.number}</td>
        <td style = "cursor:pointer"  onclick="detailPlayer('${player.playerName}') ">${player.playerName} </td>
      </tr>
</c:forEach>
 </tbody>
  </table>
  </div>
  
  <!-- 선수 상세  -->
  <div class = "col-sm-5">
    <table class="table table-dark table-striped">
  <h3>선수정보</h3>
    <thead>
      <tr>
        <th>NO.</th>
        <th>이름</th>
        <th>포지션</th>
      </tr>
    </thead>
<tbody id = "detail__Player">
 </tbody>
  </table>
  </div>
  </div>
  </div>
</body>
</html>

<script>
function playerList(teamName){
		$.ajax({
			
			type : "get",
			url : "/baseball/team?cmd=playerList&teamName="+teamName,
			dataType : "JSON"
				
		}).done(function(result){
			$("#player__List").empty();
			$("#detail__Player").empty();
			for(var player of result){

				var String = " <tr>\r\n" + 
				"        <td>"+player.number+"</td>\r\n" + 
				"        <td style = \"cursor:pointer\" onclick=\"detailPlayer('"+player.playerName+"')\" >"+player.playerName+"</td>\r\n" + 
				"      </tr>";
		
		$("#player__List").append(String);
			}
			
		}).fail(function(result){
			alert("실패");
		});
}


function detailPlayer(playerName) {
	$.ajax({
		type : "get",
		url : "/baseball/player?cmd=detailPlayer&playerName="+playerName,
		dataType : "JSON"
			
	}).done(function(result){
		
		$("#detail__Player").empty();
		
		for(var player of result){

			var String = 		"     <tr>\r\n" + 
			"	        <td>"+player.number+"</td>\r\n" + 
			"	        <td>"+player.playerName+" </td>\r\n" + 
			"	        <td>"+player.position+" </td>\r\n" + 
			"	      </tr>"
	
	$("#detail__Player").append(String);
	}
		
	}).fail(function(result){
		alert("실패");
	});
}
</script>
