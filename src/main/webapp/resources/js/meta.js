/*
*
*/


var meta=meta || {};
/****  1.common *****/

var $wrapper= $('#wrapper');	
meta.common=(function(){
	var init=function(ctx){
		alert('1111'+ctx);
		onCreate();
		meta.session.init(ctx);
		meta.index.init();
		
	};
	var onCreate=function(ctx){
		setContentView();
	};
	var setContentView=function(){
	};
	return {
	init : init
	};
})();

/****  2.path *****/
var $$= function(){return meta.session.getPath('ctx');};
var js= function(){return meta.session.getPath('js');};
var css= function(){return meta.session.getPath('css');};
var img= function(){return meta.session.getPath('img');};

/****  3.session *****/
meta.session = (function(){
	var init =function(ctx){
		sessionStorage.setItem('ctx',ctx);
		sessionStorage.setItem('js',ctx + '/resources/js');
		sessionStorage.setItem('img',ctx + '/resources/img');
		sessionStorage.setItem('css',ctx + '/resources/css');
	};
	var getPath = function(x){
		return sessionStorage.getItem(x);
	};
	return {
		init : init,
		getPath : getPath
	};
})();

meta.index=(function(){
	var $wrapper;	
	var init=function(){
		alert('이미지'+js())
		onCreate();
		
	};
	var onCreate=function(){
		setContentView();
		
		$('#btn').on('click',function(){
			alert('클릭');
		$('#wrapper').empty();	
	});
	};
	var setContentView=function(){
		$wrapper=$('#wrapper');
		var $image=$('<img/>',
				{
					id:'loding',
					src:img()+'/123.gif'
					}
		);
		$wrapper.append($image);
		alert('이미지1111'+js())
		
		var $btn=$('<input/>',
				{
					id:'btn',
					type:'button',
					value : '곰 스톱'
				}
		);
		$wrapper.append($btn);		
		//
		
	};	return {init : init};
})();
