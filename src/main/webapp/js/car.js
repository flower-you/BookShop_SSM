function addShop(){
    var count=$("#shopCount").val();
    $("#shopCount").html($("#shopCount").val(++count));
    var t=parseFloat(count);
    // alert(typeof($("#price").val()));
    var price=parseFloat($("#price").val());
    alert(t*price);//NaN
    $("#money").html(t*price);
}

function subShop(){
    var count=$("#shopCount").val();
    if (count>1){
        $("#shopCount").html($("#shopCount").val(--count));
    }
    var price=$("#price").val();
    $("#money").html(count*price);
}
