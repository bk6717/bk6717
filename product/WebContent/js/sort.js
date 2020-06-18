//처음으로 버튼//
function goFirst(){
	$.ajax({
		type : "get",
		url : "/product/test?cmd=goFirst",
		dataType : "JSON"
			
	}).done(function(result){
		$("#my__tbody").empty();
		
		for(var product of result){

	var String = 
		
		"<tr>"+
        "<td>"+product.id+"</td>" +
        "<td>"+product.name+"</td>" +
        "<td>"+product.type+"</td>" +
        "<td>"+product.price+"</td>" +
	    "<td>"+product.count+"</td>" +
	    "<td><i style = \"cursor : pointer\" onclick = \"remove()\" class=\"glyphicon glyphicon-remove\"></i></td>"+
      	"</tr>";
	$("#my__tbody").append(String);
	
	}
		
	}
		
	).fail(function(result){
		alert("실패");
	});
}

//가격순으로 
function priceDesc(){
	$.ajax({
		type : "get",
		url : "/product/test?cmd=priceDesc",
		dataType : "JSON"
			
	}).done(function(result){
		$("#my__tbody").empty();
		
		for(var product of result){

	var String = 
		
		"<tr>"+
        "<td>"+product.id+"</td>" +
        "<td>"+product.name+"</td>" +
        "<td>"+product.type+"</td>" +
        "<td>"+product.price+"</td>" +
	    "<td>"+product.count+"</td>" +
	    "<td><i style = \"cursor : pointer\" onclick = \"remove()\" class=\"glyphicon glyphicon-remove\"></i></td>"+
      	"</tr>";
	$("#my__tbody").append(String);
	
	}
		
	}
		
	).fail(function(result){
		alert("실패");
	});
}

//판매순
function countDesc(){
	$.ajax({
		type : "get",
		url : "/product/test?cmd=countDesc",
		dataType : "JSON"
			
	}).done(function(result){
		$("#my__tbody").empty();
		
		for(var product of result){

	var String = 
		"<tr>"+
        "<td>"+product.id+"</td>" +
        "<td>"+product.name+"</td>" +
        "<td>"+product.type+"</td>" +
        "<td>"+product.price+"</td>" +
	    "<td>"+product.count+"</td>" +
	    "<td><i style = \"cursor : pointer\" onclick = \"remove()\" class=\"glyphicon glyphicon-remove\"></i></td>"+
      	"</tr>";
	$("#my__tbody").append(String);
	
	}
		
	}
		
	).fail(function(result){
		alert("실패");
	});
}


function remove(id){
	$.ajax({
		type : "post",
		url : "/product/test?cmd=remove&id="+id,
		dataType: "json"
			
	}).done(function(result){
		$("#my__tbody").empty();
		alert("삭제성공");
		for(var product of result){

			var String = 
				"<tr>"+
		        "<td>"+product.id+"</td>" +
		        "<td>"+product.name+"</td>" +
		        "<td>"+product.type+"</td>" +
		        "<td>"+product.price+"</td>" +
			    "<td>"+product.count+"</td>" +
			    "<td><i style = \"cursor : pointer\" onclick = \"remove()\" class=\"glyphicon glyphicon-remove\"></i></td>"+
		      	"</tr>";
			$("#my__tbody").append(String);
			
			}

		
	}).fail(function(result){
		alert("삭제 실패");
	});
}