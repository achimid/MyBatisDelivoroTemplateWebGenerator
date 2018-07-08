$(function(){
  $("#btnGenerate").on('click', function(e) {
    e.preventDefault();
    ajaxGenerateRequest();
  });
});

function addLoader(){
  $("#btnGenerate").html('<div class="ld ld-ring ld-spin"></div>');
  setTimeout(removeLoader,5000)
}

function removeLoader(){
  $("#btnGenerate").html('Generate');
}

function getParams(){
    return {
        'clazzNameFull' :           $('#clazzNameFull').val(),
        'clazzPackage' :            $('#clazzPackage').val(),
        'clazzAlias' :              $('#clazzAlias').val(),
        'generateHeader' :          $('#optHeader').is(':checked'),
        'generateNamespace' :       $('#optNamespace').is(':checked'),
        'generateAlias' :           $('#optAlias').is(':checked'),
        'generateResultMap' :       $('#optResultMap').is(':checked'),
        'generateSqlWhere' :        $('#optSqlWhere').is(':checked'),
        'generateInsert' :          $('#optInsert').is(':checked'),
        'generateUpdate' :          $('#optUpdate').is(':checked'),
        'generateListaPorExemplo' : $('#optListaPorExemplo').is(':checked'),
        'generateListaTodos' :      $('#optListaTodos').is(':checked'),
        'generateContaPorExemplo' : $('#optContaPorExemplo').is(':checked'),
        'generateContaTodos' :      $('#optContaTodos').is(':checked'),
        'generatePegaPorId' :       $('#optPegaPorId').is(':checked'),
        'generateApagaPorId' :      $('#optApagaPorId').is(':checked'),
        'generateFooter' :          $('#optFooter').is(':checked')
    }
}

function ajaxGenerateRequest(){
  addLoader();
  $.ajax({
    url: '/api/v1/generator',
    type: "POST",
    data: JSON.stringify(getParams()),
    contentType:"application/json; charset=utf-8",
    success: setResponse
  })
}

function setResponse(response){
    debugger;
    removeLoader();
    $('.js-xmlTemplate').removeClass('d-none');
    $('#xmlTemplate').val(response);
}
