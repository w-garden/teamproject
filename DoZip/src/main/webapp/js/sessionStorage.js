
function SessionStorage_page01(){ /*1페이지*/
	sessionStorage.setItem('est_zoning', document.getElementByName("est_zoning"));
	sessionStorage.setItem('est_use', document.getElementById("est_use"));
	sessionStorage.setItem('areaP', document.getElementById("areaP"));
	sessionStorage.setItem('areaM', document.getElementById("areaM"));
	sessionStorage.setItem('detail', document.getElementById("detail"));
	sessionStorage.setItem('detail01', document.getElementById("group_wallpaper_item"));
	sessionStorage.setItem('detail02', document.getElementById("group_floor_item"));
	sessionStorage.setItem('detail03', document.getElementById("group_kitchen_item"));
	sessionStorage.setItem('detail04', document.getElementById("group_washroom_item"));
	sessionStorage.setItem('detail05', document.getElementById("group_porch_item"));
	sessionStorage.setItem('detail06', document.getElementById("group_window_item"));
	sessionStorage.setItem('detail07', document.getElementById("group_light_item"));
	sessionStorage.setItem('detail08', document.getElementById("group_door_item"));

	alert (sessionStorage.getItem('est_zoning'));
}

function SessionStorage_page02(){ /*2페이지*/
   sessionStorage.setItem('est_bud', document.getElementById("estimate_cost").value);
   sessionStorage.setItem('est_start', document.getElementById("est_start").value);
   sessionStorage.setItem('est_end', document.getElementById("est_end").value);
	}

function SessionStorage_page03(){ /*3페이지*/
   sessionStorage.setItem('est_name', document.getElementById("name").value);
   sessionStorage.setItem('est_phone', document.getElementById("phone").value);
   sessionStorage.setItem('est_addr', document.getElementById("address").value);
   sessionStorage.setItem('est_desc', document.getElementById("paragraph").value);
	}

function SessionStorage_page04(){
	sessionStorage.setItem('')
	}

function SessionStorage_page05(){
	
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