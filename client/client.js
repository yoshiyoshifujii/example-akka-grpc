const {HelloRequest, HelloReply} = require('./helloworld_pb.js');
const {GreeterServiceClient} = require('./helloworld_grpc_web_pb.js');

const client = new GreeterServiceClient('http://' + window.location.hostname + ':8080', null, null);

const request = new HelloRequest();
request.setName("Hello");

client.sayHello(request, {}, (err, response) => {
    console.log(response.getMessage());
});
