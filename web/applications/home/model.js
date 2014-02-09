wdefine(['css!../../applications/home/theme'], function(){
	var homeModel = new FwBase.Wtf.Model('navmodel', {url: "homeinfos"});
	$app.model("navmodel", homeModel);
	
	$app.metadata('container_card', {items: [{id: 'container_wtf_app', text: 'wtfappcard'}, {id: 'container_ext_app', text: 'wtfextapp'}]}); 
});
