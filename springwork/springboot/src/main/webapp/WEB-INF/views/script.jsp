<script>
    // let nums = [5,10,15,20];
    // let f = function (n){
    //     return n>10;
    // }
    // let over10 = nums.filter(f);
    // console.log(over10);

    let nums = [5,10,15,20];
    let firstOver10 = nums.find(function (n){
        return n>10;
    });
    console.log(firstOver10);


</script>
