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

}

function ajaxGenerateRequest(){
  addLoader();
  $.get( "/api/v1/generator", setResponse);
}

function setResponse(response){
    removeLoader();
    $('.js-xmlTemplate').removeClass('d-none');
    $('#xmlTemplate').val(response);
}
