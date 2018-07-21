$(function(){
  $("#btnGenerate").on('click', function(e) {
    e.preventDefault();
    ajaxGenerateRequest();
  });

  $(".js-button-add-field").on('click', addNewField);
});

function addLoader(){
  $("#btnGenerate").html('<div class="ld ld-ring ld-spin"></div>');
  setTimeout(removeLoader,5000)
}

function removeLoader(){
  setTimeout(function(){
    $("#btnGenerate").html('Generate');
  },500);
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
        'generateFooter' :          $('#optFooter').is(':checked'),
        'fields' :  $( ".js-field" ).map(function() {return this.value;}).get()
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
    removeLoader();
    $('.js-xmlTemplate').removeClass('d-none');
    $('#xmlTemplate').val(response);
    scrollToTextArea();
}

function scrollToTextArea(){
    $('html,body').animate({
          scrollTop: $('#xmlTemplate').offset().top
    }, 1000);
}

function addNewField(){
    var nField =
    `<div class="input-group">
         <input type="text" class="form-control js-field" placeholder="New Field Ex: idOrder">
         <span class="input-group-btn">
           <button type="button" class="btn btn-secondary js-button-remove-field" onclick="$(this).parent().parent().remove();">
             <i class="fa fa-trash-o" aria-hidden="true"></i>
           </button>
         </span>
     </div>`;
    $('.js-fields-list').append(nField);
}