
/* 공통 ajax */

/* GET 방식 */

function getAjax(url){
    $.ajax({
        type : 'GET',
        url : url,
        data: {},
        dataType: 'JSON',
        success: function(response){
            getSuccess(response);
        },error: function(e){
            console.log(e);
        }
    });
}


/* POST, PUT, DELETE 방식 */
/**
 * type : POST, PUT, DELETE
 * url : 이동 url
 * param : json 형태
 */

function httpAjax(type, url, params){
    $.ajax({
        type : type,
        url : url,
        data : params,
        dataType : 'JSON',
        success : function(response){
	            httpSuccess(response);
        },error: function(e){
            console.log(e);
        }
    });
}


/* 파일 전송 ajax */
/**
 * type : POST, PUT, DELETE
 * url : 이동 url
 * formData : 파일이 포함된 데이터(josn 형태)
 */

function fileAjax(type, url, formData){
    $.ajax({
        type : type,
        url : url,
        data : formData,
        contentType : false,
        processData : false,
        enctype : 'multipart/form-data',
        success : function(response){
            fileSuccess(response);
        },error : function(e){
            console.log(e);
        }
    });
}


/* 파일 미리보기 */
/**
 * 이미지 미리보기 div 요소 id : id="imgPreview"
 * 이미지 미리보기 div 요소 css : class="priview" *클래스 스타일은 별도 지정 필요
 */
function preview(img){
    var reader;
    $('#imgPreview').empty();

    for(var file of img.files){
        reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function(e){
            $('#imgPreview').append('<img class="priview" src="' + e.target.result + '"/>');
        }
    }
}


