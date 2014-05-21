<script>
$(function() {
    $('#datepicker').datepicker({
        dateFormat: 'yy-dd-mm',
        onSelect: function(datetext){
            var d = new Date();
            datetext=datetext+" "+d.getHours()+": "+d.getMinutes()+": "+d.getSeconds();
            $('#datepicker').val(datetext);
        }
});
});
</script>