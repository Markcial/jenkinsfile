class DockerCompose {
    def DockerCompose(options) {
        println options
        println "New DockerCompose"
    }
}

def call(options) {
    return new DockerCompose(options);
}

return call([]);
