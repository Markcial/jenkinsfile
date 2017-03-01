def composer(options) {
  def sshSocket = file(env.SSH_AUTH_SOCK)
  def args = ['-v ${env.WORKSPACE}:/app']
  if(sshSocket.exists()) {
    args = [
      '-v ${sshSocket.parent()}:${sshSocket.parent()}',
      '-e SSH_AUTH_SOCK=${sshSocket}'
    ]
  }
  echo args
  docker.image('composer/composer').withRun(args, 'install --ignore-platform-reqs')
}
