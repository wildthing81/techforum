/*
 *All fucntions for dashboard.jsp
 *
 */

$(function (){

    $('#questionbankref').on("click", function () {
        $('section').find('.active').hide();
        $('#activity-navbar-collapse').find('.active').removeClass("active");
        $(this).addClass("active");
        $('#landing').hide();
        $('#qbankform').show().addClass("active");
    });

    $('#topicref').on("click", function () {
        $('section').find('.active').hide();
        $('#activity-navbar-collapse').find('.active').removeClass("active");
        $(this).addClass("active");
        $('#landing').hide();
        $('#topicform').show().addClass("active");
    });

    $('#questionref').on("click", function () {
        $('section').find('.active').hide();
        $('#activity-navbar-collapse').find('.active').removeClass("active");
        $(this).addClass("active");
        $('#landing').hide();
        $('#questionform').show().addClass("active");
    });

    //get list of questions
    $.getJSON("rest/questionList", function (questionList) {
        $("#qtable > tbody").empty();
        $.each(questionList, function (key, questionObj) {
        	var tr;
			tr = $('<tr/>');
			var td = "<td style='text-align:center'";
			tr.append(td+"><div class='checkbox'><label><input type='checkbox' value=''>"
					  + questionObj.qBankID
					  +"</label></div></td>");
			tr.append(td + "class='questionId'>"
					+ questionObj.question
					+ "</td>");
			tr.append("<td><button type='button' class='btn btn-primary'>Answer</button></td>");
			$('#qtable > tbody').append(tr);
        });
    });
    
    $('#taketestref').on("click", function () {
        $('section').find('.active').hide();
        $('#activity-navbar-collapse').find('.active').removeClass("active");
        $(this).addClass("active");
        $('#landing').hide();
        //Streams
        $.getJSON("rest/lookup/getstreams", function (data)
        {
            $("#examform #streams").empty();
            $.each(data, function (key, val) {
                var streamcheckbox = "<div class='checkbox'><label>" +
                        "<input type='checkbox' name='streamid' value='" + key + "'>" + val + "</label></div>";


                $("#examform #streams").append(streamcheckbox);
            });
        });
        

        //exam length
        $.getJSON("rest/lookup/examduration", function (data) {
            $("#examform #examduration").empty();
            $.each(data, function (key, val) {
                var duration = "<div class='radio'><label>" +
                        "<input type='radio' name='examduration' value='" + val + "'>" + val + " </label></div>";


                $("#examform #examduration").append(duration);
            });

        });

        $('#examform').show().addClass("active");
    });

    $('#addchoice').on("click", function (event) {
        var choice = "<input type='text' class='form-control' style='width:50%'" +
                "name='choices' placeholder='Enter Answer Choice'/><br>";

        $('#multichoiceform').find(".form-group:nth-child(2) br").last().after(choice);
    });
});
