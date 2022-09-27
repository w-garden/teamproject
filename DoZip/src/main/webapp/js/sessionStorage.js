
function SessionStorage_page01(){ /*1페이지*/
	sessionStorage.setItem('est_zoning', document.getElementByName("est_zoning"));
	sessionStorage.setItem('est_use', document.getElementByName("est_use"));
	sessionStorage.setItem('areaP', document.getElementByName("areaP"));
	sessionStorage.setItem('areaM', document.getElementByName("areaM"));
	sessionStorage.setItem('detail', document.getElementByName("check"));
	sessionStorage.setItem('detail01', document.getElementByName("group_wallpaper_item"));
	sessionStorage.setItem('detail02', document.getElementByName("group_floor_item"));
	sessionStorage.setItem('detail03', document.getElementByName("group_kitchen_item"));
	sessionStorage.setItem('detail04', document.getElementByName("group_washroom_item"));
	sessionStorage.setItem('detail05', document.getElementByName("group_porch_item"));
	sessionStorage.setItem('detail06', document.getElementByName("group_window_item"));
	sessionStorage.setItem('detail07', document.getElementByName("group_light_item"));
	sessionStorage.setItem('detail08', document.getElementByName("group_door_item"));

	//alert (sessionStorage.getItem('est_zoning'));
}

function SessionStorage_page02(){ /*2페이지*/
   sessionStorage.setItem('est_bud', document.getElementById("estimate_cost").value);
   sessionStorage.setItem('est_start', document.getElementById("est_start").value);
   sessionStorage.setItem('est_end', document.getElementById("est_end").value);
	}

function SessionStorage_page03(){ /*3페이지*/
   sessionStorage.setItem('est_name', document.getElementById("name").value);
   sessionStorage.setItem('est_phone', document.getElementById("phone").value);
   sessionStorage.setItem('est_addr', document.getElementById("addr").value);
   sessionStorage.setItem('est_desc', document.getElementById("paragraph").value);
	}

function SessionStorage_page04(){
	sessionStorage.setItem('')
	}

function SessionStorage_page05(){
	
	}

function test(){
	var est_zoning = sessionStorage.getItem('est_zoning');
	var est_use = sessionStorage.getItem('est_use');
	var areaP = sessionStorage.getItem('areaP');
	var areaM = sessionStorage.getItem('areaM');
	var detail = sessionStorage.getItem('detail');
	var detail01 = sessionStorage.getItem('detail01');
	var detail02 = sessionStorage.getItem('detail02');
	var detail03 = sessionStorage.getItem('detail03');
	var detail04 = sessionStorage.getItem('detail04');
	var detail05 = sessionStorage.getItem('detail05');
	var detail06 = sessionStorage.getItem('detail06');
	var detail07 = sessionStorage.getItem('detail07');
	var detail08 = sessionStorage.getItem('detail08');
	
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
			est_zoning : est_zoning,
			est_use : est_use,
			areaP : areaP,
			areaM : areaM,
			detail : detail,
			detail01 : detail01,
			detail02 : detail02,
			detail03 : detail03,
			detail04 : detail04,
			detail05 : detail05,
			detail06 : detail06,
			detail07 : detail07,
			detail08 : detail08,
			
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