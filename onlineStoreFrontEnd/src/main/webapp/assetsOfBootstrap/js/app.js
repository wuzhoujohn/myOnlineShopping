$(function(){
	switch(menu) {
		case 'about page':
			$('#about').addClass('active');
			break;
		case 'contact page':
			$('#contact').addClass('active');
			break;
		default :
			$('#home').addClass('active');
			break;
	}
});