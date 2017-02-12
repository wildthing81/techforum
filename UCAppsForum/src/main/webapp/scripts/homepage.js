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
        //questions count
        $.getJSON("rest/lookup/questioncount", function (data) {
            $("#examform #questioncount").empty();
            $.each(data, function (key, val) {
                var radiocount = "<div class='radio'><label>" +
                        "<input type='radio' name='questioncount' value='" + val + "'>" + val + "</label></div>";


                $("#examform #questioncount").append(radiocount);
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
