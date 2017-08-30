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
				data: 'code',
				mRender: function(data, type, row){
					return '<img src="'+window.contextRoot+'/resources/pictures/'+data+'.jpg" class="dataTableImgs" />';
				}
			},
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
				data: 'quantity',
				mRender: function(data, type, row){
					if(data < 1){
						return '<span style="color: red">Out Of Stock!</span>';
					}
					return data;
				}
			},
			{
				data: 'id',
				mRender: function(data, type, row){
					var str = '';
					str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160; &#160;';
					
					if(row.quantity < 1){
						str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}else{
						str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
					}
					
					return str;
				}
			}
		]
		
	});
}