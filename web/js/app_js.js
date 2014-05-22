<script>
$(document).ready(function () {
    $(".tableForm").prop('disabled', true);
    $("#edit").click(function () {
    $(".tableForm").prop('disabled', false);
    });
$("input[type='datetime']").datepicker({
    minDate: 0,
    dateFormat: 'yy-dd-mm',
    onSelect: function (datetext) {
    var d = new Date();
    datetext = datetext + " " + d.getHours() + ": " + d.getMinutes() + ": " + d.getSeconds();
    $("input[type='datetime']").val(datetext);
    }
});

});
$(function () {
    $('#date').datepicker({
        minDate: 0,
        dateFormat: 'yy-dd-mm',
        onSelect: function (datetext) {
            var d = new Date();
            datetext = datetext + " " + d.getHours() + ": " + d.getMinutes() + ": " + d.getSeconds();
            $('#date').val(datetext);
        }
});
});


</script>