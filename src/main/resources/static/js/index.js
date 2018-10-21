$(function(){
  $("#btnGenerate").on('click', function(e) {
    e.preventDefault();
    ajaxGenerateRequest();
  });

  $(".js-button-add-field").on('click', addNewField);
  $(document).on('change', '.custom-select', validaPK);
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
        'fields' :                  getFieldsTypes()
    }
}

function getFieldsTypes(){
    return $( ".js-field" ).map(function() {
        obj = {};
        obj[$(this).closest('.input-group').find('.js-field').val().toString()] =
        $(this).closest('.input-group').find('.js-field-type').val();
        return obj;
    }).get();
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
    `
        <div class="input-group">
          <input class="form-control js-field" placeholder="Ex: idOrder" type="text">
          <div class="input-group-append">
            <select class="custom-select js-field-type" id="inputGroupSelect01">
                <option value="String" selected>String</option>
                <option value="Integer">Integer</option>
                <option value="Boolean">Boolean</option>
                <option value="Date">Date</option>
                <option value="SmallInt">SmallInt</option>
                <option value="PK">PRIMARY KEY</option>
                <div role="separator" class="dropdown-divider"></div>
            </select>
          </div>
          <div class="input-group-append">
                <button type="button" class="btn btn-secondary js-button-remove-field" onclick="$(this).closest('.input-group').remove();">
                  <i class="fa fa-trash-o" aria-hidden="true"></i>
                </button>
          </div>
        </div>
    `;

    $('.js-fields-list').append(nField);
    validaPK();
}

function validaPK(){
    if($('.js-field-type').find('option:selected[value="PK"]').length > 0){
        $('.js-field-type').find('option:not(:selected)[value="PK"]').hide();
    }else{
        $('.js-field-type').find('option[value="PK"]').show();
    }
}