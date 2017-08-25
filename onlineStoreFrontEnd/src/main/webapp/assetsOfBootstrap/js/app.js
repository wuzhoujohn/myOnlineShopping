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
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
	}
});