let id;

function handleSearch(event){
    if(id){
        clearTimeout(id);
    }
    id =setTimeout(() => {
        console.log("Make API Calls ", event.target.value);

    } , 2000);

}
 