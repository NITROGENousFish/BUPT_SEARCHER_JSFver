
// Chart.JS
$(function() {
    Chart.defaults.global.responsive = true;

    var ctx = $("#dashboard-order-chart").get(0).getContext("2d");
    var ctx2 = $("#dashboard-stat-chart").get(0).getContext("2d");
    var options = {
        bezierCurve: false,
        pointDotRadius : 8,
        datasetStroke : true,
        datasetStrokeWidth : 2,
        scaleGridLineColor : "rgba(0,0,0,.05)",
        scaleFontColor: "#666",
        scaleLineColor: "rgba(0,0,0,0)",
        scaleShowVerticalLines: false,
        scaleShowGridLines : true,
        scaleOverride: false,
        scaleSteps: 10,
        pointDotStrokeWidth : 2,

    }

    var options2 = {
        percentageInnerCutout : 75,
        legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>"
    }
    var data = {
        labels: document.getElementById("Seven_Days").value.split(','),
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(0,177,106,0.3)",
                strokeColor: "rgba(0,177,106,1)",
                pointColor: "#FFF",
                pointStrokeColor: "rgba(0,177,106,1)",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: document.getElementById("Seven_Days_Search_Times").value.split(',')
            }
        ]
    };
    
    var data2 = eval("(" + document.getElementById("wordlist").value.split(',') + ")");

    var myLineChart = new Chart(ctx).Line(data, options);
    var myBarChart = new Chart(ctx2).Doughnut(data2, options2);
  var legend = myBarChart.generateLegend();
  $("#dashboard-stat-chart-legend").append(legend);
});