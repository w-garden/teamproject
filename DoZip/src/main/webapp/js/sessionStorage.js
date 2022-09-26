
function SessionStorage(){
/*1페이지*/
	
/*2페이지*/
   sessionStorage.setItem('est_bud', document.getElementById("estimate_cost").value);
   sessionStorage.setItem('est_start', document.getElementById("est_start").value);
   sessionStorage.setItem('est_end', document.getElementById("est_end").value);
/*3페이지*/
   sessionStorage.setItem('est_name', document.getElementById("name").value);
   sessionStorage.setItem('est_phone', document.getElementById("phone").value);
   sessionStorage.setItem('est_addr', document.getElementById("address").value);
   sessionStorage.setItem('est_desc', document.getElementById("paragraph").value);
/*4페이지*/

}

function test(){
	var est_bud = sessionStorage.getItem('est_bud');
	var est_start = sessionStorage.getItem('est_start');
	var est_end = sessionStorage.getItem('est_end');
	
	var est_name = sessionStorage.getItem('est_name');  
	var est_phone = sessionStorage.getItem('est_phone'); 
	var est_addr = sessionStorage.getItem('est_addr');
	var est_desc = sessionStorage.getItem('est_desc'); 
	
	$.ajax({
		type:"post", 
		url:'estimate_apply5_ok.do', 
		data:{
			est_bud : est_bud,
			est_start : est_start,
			est_end : est_end,
			
			est_name : est_name, 
			est_phone: est_phone,
			est_addr : est_addr,
			est_desc : est_desc
		},
		datatype: "text",
		
		success : function(result){
			
			alert('완료!');
			location.reload();
		}
	});
}