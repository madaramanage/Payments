
$(document).on("click","#btnLogin",function()
{
	var result = isValidFormLogin();
	if(result=="true")
		{ $("#formLogin").submit(); }
	
	else
		{ $("#divStsMsgLogin").html(result); }
		
});


function isValidFormLogin()
{
	if($.trim($("#txtUserName").val())=="")
		{ return "enter username"; }
	
	if($.trim($("#txtPassword").val())=="")
	{ return "enter Password"; }
	
	return "true";
}

function isValidFormPayment()
{
	if($.trim($("#txtItemName").val())=="")
	{ return "enter item name"; }
	return "true/false";
}


$(document).on("click","#btnSave",function()
{
			var result = isValidFormPayment();
			if(result=="true")
				{ $("#formPayments").submit(); }
			
			else
				{ $("#divStsMsgItem").html(result); }
				
});


$(document).on("click","#btnEdit",function()
{
	$("#hidMode").val(update);
	$("#hidID").val($(this).attr("param"));
	$("#txtItemName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#txtaccno").val($(this).closest("tr").find('td:eq(2)').text());
		$("#txtaddr").val($(this).closest("tr").find('td:eq(2)').text());
	
});

$(document).on("click","#btnRemove", function()
{
	$("#hidMode").val("remove");
	$("#hidID").val($(this).attr("param"));
	var res = confirm("are you sure?");
		if(res == true){
			$("#formPayments").submit();
		}


});
