PROTOBUF_DIR=./src/main/protobuf
CLIENT_DIR=./client

proto-js:
	protoc -I=$(PROTOBUF_DIR) helloworld.proto \
		--js_out=import_style=commonjs:$(CLIENT_DIR) \
		--grpc-web_out=import_style=commonjs,mode=grpcwebtext:$(CLIENT_DIR)
