define(function(){
	var currApp = $app;
	return {
		navigateSelection: function(taskId, taskType, params) {
			params = params | {};
			if(taskType == "ext3"){
				if(clientMode){
					alert("ext3 app isn't supported in client mode");
					return;
				}
				this.navigateExt3Task(taskId, params);
			}
			else if(taskType == "ext4"){
				if(clientMode){
					alert("ext4 app isn't supported in client mode");
					return;
				}
				this.navigateExt4Task(taskId, params);
			}
			else{
				this.navigateWtfTask(taskId, params);
			}
		},
		swtichTaskContainer: function(isWtf) {
			var card = currApp.component("container_card");
			var index = card.active();
			if(isWtf){
				if(index != 0)
					card.active(0);
			}
			else{
				if(index != 1){
					$("#ext_legacy_iframe").css({
						width: "100%",
						height: "500px"
					});
					card.active(1);
				}
			}
		},
		navigateExt3Task: function(taskId, params){
			this.swtichTaskContainer(false);
    		Jx.shell.legacyFrame.openTask( taskId, params  );
    		workspace.activateLegacyCard();
		},
		navigateExt4Task: function(taskId, params){
			this.swtichTaskContainer(false);
    		params.taskId = taskId;
    		Jx.shell.createTask(taskClass, params);
    	
	    	/*Fire event 'taskcreated' if App needs to handle different cases once a Shell task is created
	    	 * Ex: Task might want to navigateTo a legacy task based on some actions after the Shell task
	    	 * is created.
	    	 */
    		
    		var currentTask = Junos.Spaces.foundation.task.Task.currentTask;
    		if(currentTask) {
    			currentTask.fireEvent('taskcreated', currentTask);
    		}
		},
		navigateWtfTask: function(taskId, params){
			this.swtichTaskContainer(true);
		}
	};
});