wdefine(['./homenav'], function(homenav){
	$(window).unload(function(){
		
	});
	$(window).resize(function() {
		resizeSideBar();
	});
	
	function resizeSideBar() {
		var total = $(window).height();
		$('#sys_hometable').parent().siblings("DIV").each(function(){
			total = total - $(this).outerHeight();
		});
		
		$('#sys_hometable tr:eq(0) td:eq(0) #sidenavdiv').css('min-height', total);
	}
	
	resizeSideBar();
	
	$app.on('loaded', function(){
		FwBase.Wtf.Application.navigateTo(window.mainCtx + "/dashboard");
		initLegacyFrames();
	});
	
	var homeModel = $app.model("navmodel");
	homeModel.on("add", function(){
		var row = this.page().at(0);
		var navList = row.get("navList");
		if(navList != null){
			var sidenav = this.ctx.component("homesidenav");
			for(var i = 0; i < navList.length; i ++){
				sidenav.addItem(navList[i]);
			}
		}
	});
	$app.component("homesidenav").on("selection", function(){
		homenav.navigateSelection(taskId, taskType, params);
	});
	
	function initLegacyFrames() {
		$("#ext_legacy_iframe").attr("src", "/mainui/ext4Legacy.jsp");
	}
});
