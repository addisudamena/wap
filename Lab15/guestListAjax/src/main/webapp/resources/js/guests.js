$(function() {
    $("#send").click(updateGuests);
});

function updateGuests() {
    var first = $("#first").val();
    var last = $("#last").val();

    $.ajax("guest.ajax", {
		"type": "post",
		"data": {
        	"first": first,
                "last": last
		}
    }).done(displayGuests);
}

function displayGuests(data) {
    //var guestList = "You need to modify this method to display the updated guest list.  Remember to build the entire list before adding it to the DOM.";
    let guestList="";

    //I have changed the guestList div to Ol
    $.each(data, (index, guest)=>guestList=guestList.concat("<li>"+guest.first+" "+guest.last+"</li>"));
    $("#guestList").html(guestList);

}
