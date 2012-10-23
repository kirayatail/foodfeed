function handleRem(button){
    counter = $('.ingredient').length;
        
    var at = button.value;
    
    if($('.ingredient').length > 1){
        $('.ingredient-index-'+at).remove();

        for(var i=at; i<counter; i++){
            $('.ingredient-index-'+(parseInt(i)+1)).attr("class", 'ingredient clearfix ingredient-index-'+i);
            
            $('.grocery-label-'+(parseInt(i)+1)).attr("for", 'ingredients'+i+'.grocery.id');
            $('.grocery-label-'+(parseInt(i)+1)).attr("class", 'grocery-label-'+i);
            $('#ingredients'+(parseInt(i)+1)+'\\.grocery\\.id').attr("name", 'ingredients['+i+'].grocery.id');
            $('#ingredients'+(parseInt(i)+1)+'\\.grocery\\.id').attr("id", 'ingredients'+i+'.grocery.id');

            $('.amount-label-'+(parseInt(i)+1)).attr("for", 'ingredients'+i+'.amount');
            $('.amount-label-'+(parseInt(i)+1)).attr("class", 'amount-label-'+i);
            $('#ingredients'+(parseInt(i)+1)+'\\.amount').attr("name", 'ingredients['+i+'].amount');
            $('#ingredients'+(parseInt(i)+1)+'\\.amount').attr("id", 'ingredients'+i+'.amount');

            $('.unit-label-'+(parseInt(i)+1)).attr("for", 'ingredients'+i+'.unit');
            $('.unit-label-'+(parseInt(i)+1)).attr("class", 'unit-label-'+i);
            $('#ingredients'+(parseInt(i)+1)+'\\.unit').attr("name", 'ingredients['+i+'].unit');
            $('#ingredients'+(parseInt(i)+1)+'\\.unit').attr("id", 'ingredients'+i+'.unit');
            
            $('.remove-index-'+(parseInt(i)+1)).attr("value", i);
            $('.remove-index-'+(parseInt(i)+1)).attr("class", 'button remove-ingredient remove-index-'+i);
        }
    }
}

Aloha.settings.sidebar = {
    disabled: true 
}

// Add Aloha editor on elements with editable class
Aloha.ready( function() {
    var $ = Aloha.jQuery;
    $('.editable').aloha();
});

$(document).ready(function(){
    $( ".autocomplete" ).autocomplete({
        source: "/foodfeed/grocery",
        minLength: 2
    });
    
    $(".add-ingredient").click(function(event){
        event.preventDefault();
        
        counter = $(".ingredient").length;
        
        var html = "<div class='ingredient clearfix ingredient-index-"+counter+"'>\n"
                    + "<div class='ingredient-field'>\n"
                    + "<label class='grocery-label-"+counter+"' for='ingredients"+counter+".grocery.id'>Name</label>\n"
                    + "<input id='ingredients"+counter+".grocery.id' class='textform autocomplete ui-autocomplete-input' type='text' value='' name='ingredients["+counter+"].grocery.id' autocomplete='off'>\n"
                    + "<span class='ui-helper-hidden-accessible' role='status' aria-live='polite'></span>\n"
                    + "</div><div class='ingredient-field'>\n"
                    + "<label class='amount-label-"+counter+"' for='ingredients"+counter+".amount'>Amount</label>\n"
                    + "<input id='ingredients"+counter+".amount' class='textform' type='text' value='' name='ingredients["+counter+"].amount'>\n"
                    + "</div><div class='ingredient-field'>\n"
                    + "<label class='unit-label-"+counter+"' for='ingredients"+counter+".unit'>Unit</label>\n"
                    + "<input id='ingredients"+counter+".unit' class='textform' type='text' value='' name='ingredients["+counter+"].unit'>\n"
                    + "</div>\n"
                    + "<button type='submit' class='button remove-ingredient remove-index-"+counter+"' name='remove-ingredient' value="+counter+">Remove</button>\n"
                    + "</div>";
        
        $(html).insertBefore('.add-ingredient');
        
        $('.remove-index-'+counter).click(function(event){
            event.preventDefault();
        
            handleRem(event.target);
        });
    });
    
    $(".remove-ingredient").click(function(event){
        event.preventDefault();
        
        handleRem(event.target);
    });
});