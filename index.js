const http = require('http');
const port = 3000;
const logResponse = require('./util'

    const server = http.createServer( function(req,res){
        logResponse();
        res.end('Iam your backend! Hurray')
    })

    server.listen(port ,function() {
        console.log('Server is running')
    })
)