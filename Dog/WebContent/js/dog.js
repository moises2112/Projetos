/**
 * 
 */

$(document).ready(function() {
	$('.btn-editar').click(function() {
		$('.formscadastro').slideUp('fast');
		$('.formsedicao').slideToggle('fast');

	});
	$('.btn-inserir').click(function() {
		$('.formsedicao').slideUp('fast');
		$('.formscadastro').slideToggle('fast');

	});
});