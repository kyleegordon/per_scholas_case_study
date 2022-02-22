

$('.change-color').each(function() {
    if($(this).html() == 'A') {
        $(this).addClass('colorA');
    } else if($(this).html() == 'B') {
        $(this).addClass('colorB');
    } else if($(this).html() == 'C') {
        $(this).addClass('colorC');
    } else if($(this).html() == 'D') {
        $(this).addClass('colorD');
    } else if($(this).html() == 'F') {
        $(this).addClass('colorF');
    }
});