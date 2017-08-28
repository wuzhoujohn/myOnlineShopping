$(function(){
	switch(menu) {
		case 'about page':
			$('#about').addClass('active');
			break;
		case 'contact page':
			$('#contact').addClass('active');
			break;
		case 'all products':
			$('#products').addClass('active');
			break;
		default :
			if(menu == "home page") break;
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
});

//code for Jquery dataTable

var $table = $('#productListTable');


//execute the below code only where we have this table
if($table.length){	
	var jsonUrl = '';
	if(window.categoryId == ''){
		jsonUrl = window.contextRoot + "/json/data/all/products";
	}else{
		jsonUrl = window.contextRoot + "/json/data/category/" + window.categoryId + '/products';
	}
	
	$table.DataTable({
		lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All Records']],
		pageLength: 5,
		ajax:{
			url: jsonUrl,
			dataSrc: ''
		},
		columns: [
			{
				data: 'name'
				
			},
			{
				data: 'brand'
			},
			{
				data: 'unitPrice',
				mRender: function(data, type, row){
					return '$' + data;
				}
			},
			{
				data: 'quantity'
			},
			{
				data: 'id'	
			}
		]
		
	});
}