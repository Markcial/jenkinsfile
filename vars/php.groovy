def composer(options) {

  def args = ['-v ${env.WORKSPACE}:/app']

  if (env.SSH_AUTH_SOCK) {
    def sshSocket = new File(env.SSH_AUTH_SOCK)
    if(sshSocket.exists()) {
      args = [
        '-v ${sshSocket.parent()}:${sshSocket.parent()}',
        '-e SSH_AUTH_SOCK=${sshSocket}'
      ]
    }
  }

  echo args
  docker.image('composer/composer').withRun(args, 'install --ignore-platform-reqs')
}
