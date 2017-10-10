

$(document).ready(function() {
	
	$('.btn-editar').click(function() {
		$(".idatualizar").val($(this).attr("var"));
		$(".nomeedit").val($(this).closest("tr").find("td.editNome").text());
		$(".idadeedit").val(parseInt($(this).closest("tr").find("td.editIdade").text()));
		$(".racaedit").val($(this).closest("tr").find("td.editRaca").text());
		if ($(this).closest("tr").find("td.editSexo").text()=="M"){
			$(".sexoeditm").attr('checked', true);
		}
		else
			$(".sexoeditf").attr('checked', true);
		
	});

});