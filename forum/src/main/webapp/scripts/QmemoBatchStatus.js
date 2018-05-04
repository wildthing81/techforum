/**
 * Author:Ramaswamy R
 * Purpose: This file contains JQuery functions related to monitoring of Qmemo batch upload jobs 
 * Date:20/03/2015
 * */
$(function(){	
	
	pageRefresh();
	$('#qmemoziptable').on("click",'a.ziprow',function(event){
		//window.open(this.href);
		event.preventDefault();
		var uploadId=$(this).parent().prev().text();
		var batchFileName=$(this).text();
		jobDetailsRefresh(batchFileName,uploadId);
	});

	filterByBussDate();
	
});

function colorcodeFileStatus(){
	$('#qmemoziptable').find("td.fileStatus").css("color", function( index ){
		if ($(this).text()=="IN PROGRESS")
			return "blue";
		
		if ($(this).text()=="SUCCESS")
			return "green";
		
		if ($(this).text()=="FAILED")
			return "red";
	});	
}

function colorcodeJobStatus(){
	$('#qmemojobtable').find("td.jobStatus").css("color", function( index ){
		if ($(this).text()=="IN PROGRESS")
			return "blue";
		
		if ($(this).text()=="SUCCESS")
			return "green";
		
		if ($(this).text()=="FAILED")
			return "red";
	});	
}

function pageRefresh()
{
	//var userid='${sessionScope.soeid}';
	var userid = $("#soeid").val();
	
	$('#sectionBatchFileGrid').find("table#qmemoziptable > tbody").empty();
	$('#sectionSpringJobGrid').find("table#qmemojobtable > tbody").empty();		 
	$("#sectionBatchFileHeader").find("#batchfileheader").empty();
	$("#sectionBatchFileHeader").find("#uploadId").empty();
	
	$
	.getJSON(
			"${pageContext.request.contextPath}/QmemoBatchUploadInfoAction.action?method:load",
			{
				soeid : userid
			}, function(qmemoBatchUploadInfoArr) {
				$.each(qmemoBatchUploadInfoArr, function(index,
						QmemoBatchUploadInfoObj) {
					var tr;
					tr = $('<tr/>');
					var td = "<td style='text-align:center'";
					//tr.append("<td/>");
					tr.append(td + "class='uploadId'>"
							+ QmemoBatchUploadInfoObj.uploadId
							+ "</td>");
					tr.append(td + "class='batchFileName'>"
							+ "<a class='ziprow' href='xxxx?"
							+ QmemoBatchUploadInfoObj.batchFileName
							+ "'>"
							+ QmemoBatchUploadInfoObj.batchFileName
							+ "</a></td>");
					tr.append(td + "class='qMemoBusDate'>"
							+ QmemoBatchUploadInfoObj.qMemoBusDate
							+ "</td>");
					tr.append(td + "class='uploadDate'>"
							+ QmemoBatchUploadInfoObj.uploadDate
							+ "</td>");
					tr.append(td + "class='fileStatus'>"
							+ QmemoBatchUploadInfoObj.fileStatus
							+ "</td>");
					tr.append(td + "class='completionDate'>"
							+ QmemoBatchUploadInfoObj.completionDate
							+ "</td>");
					$('#sectionBatchFileGrid').find(
							"table#qmemoziptable > tbody").append(tr);
				});

				colorcodeFileStatus();
			});
}

function jobDetailsRefresh(batchFileName,uploadId){
				
	$('#sectionSpringJobGrid').find("table#qmemojobtable > tbody").empty();		 
	$("#sectionBatchFileHeader").find("#batchfileheader").text(batchFileName);
	$("#sectionBatchFileHeader").find("#uploadId").val(uploadId);
	
	$.getJSON("${pageContext.request.contextPath}/GetQmemoJobInfoAction.action",{zipUploadId:uploadId},function(qmemoJobInfoArr){
		$.each(qmemoJobInfoArr,function(index,QmemoJobInfoObj){
			var tr;
		  	tr = $('<tr/>');
		  	var td="<td style='text-align:center'";
		  	//tr.append("<td/>");
	        tr.append(td+"class='runId'>"+QmemoJobInfoObj.runId+"</td>");
	        tr.append(td+"class='qmemoFileName'>"+ QmemoJobInfoObj.qmemoFileName+"</td>");
	        tr.append(td+"class='jobName'>"+ QmemoJobInfoObj.jobName+"</td>");
	        tr.append(td+"class='jobStatus'>"+ QmemoJobInfoObj.jobStatus+"</td>");
	        tr.append(td+"class='runDate'>"+ QmemoJobInfoObj.runDate+"</td>");		        
	        tr.append(td+"class='completionDate'>"+ QmemoJobInfoObj.completionDate+"</td>");
	        tr.append(td+"class='goodRecCount'>"+ QmemoJobInfoObj.goodRecCount+"</td>");
	        tr.append(td+"class='badRecCount'>"+ QmemoJobInfoObj.badRecCount+"</td>");
	        $('#sectionSpringJobGrid').find("table#qmemojobtable > tbody").append(tr);
		});
		
		colorcodeJobStatus();
	});
}

function filterByBussDate(){
	

	var userid = $("#soeid").val();
	var qmemoBussDate=$("#QMEMO_BUSN_DATE").val();
	$('#filterForm')
			.on(
					"click",
					'a.QMEMO_BUSN_DATE_multiple',
					function(event) {
						event.preventDefault();
						$('#sectionBatchFileGrid').find(
								"table#qmemoziptable > tbody").empty();

						$
								.getJSON(
										"${pageContext.request.contextPath}/QmemoBatchUploadInfoAction.action!searchByBussDate",
										{
											soeid : userid,filterDate: qmemoBussDate
											
										},
										function(qmemoBatchUploadInfoArr) {
											$
													.each(
															qmemoBatchUploadInfoArr,
															function(index,
																	QmemoBatchUploadInfoObj) {
																var tr;
																tr = $('<tr/>');
																var td = "<td style='text-align:center'";
																// tr.append("<td/>");
																tr
																		.append(td
																				+ "class='uploadId'>"
																				+ QmemoBatchUploadInfoObj.uploadId
																				+ "</td>");
																tr
																		.append(td
																				+ "class='batchFileName'>"
																				+ "<a class='ziprow' href='xxxx?"
																				+ QmemoBatchUploadInfoObj.batchFileName
																				+ "'>"
																				+ QmemoBatchUploadInfoObj.batchFileName
																				+ "</a></td>");
																tr
																		.append(td
																				+ "class='qMemoBusDate'>"
																				+ QmemoBatchUploadInfoObj.qMemoBusDate
																				+ "</td>");
																tr
																		.append(td
																				+ "class='uploadDate'>"
																				+ QmemoBatchUploadInfoObj.uploadDate
																				+ "</td>");
																tr
																		.append(td
																				+ "class='fileStatus'>"
																				+ QmemoBatchUploadInfoObj.fileStatus
																				+ "</td>");
																tr
																		.append(td
																				+ "class='completionDate'>"
																				+ QmemoBatchUploadInfoObj.completionDate
																				+ "</td>");
																$(
																		'#sectionBatchFileGrid')
																		.find(
																				"table#qmemoziptable > tbody")
																		.append(
																				tr);
															});

											colorcodeFileStatus();
										});
					});
}
