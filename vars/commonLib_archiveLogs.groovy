//Archive log files
def call() {
  echo 'Executing method "commonLib_archiveLogs"'
  
  //The copy will fail if the build does not produce any npm logs, which is ok
  def npmLogsCopied=sh script: "cp -r /home/jenkins/.npm/_logs ${WORKSPACE}/npmLogs", returnStatus: true
  if (npmLogsCopied==0) {
    archiveArtifacts allowEmptyArchive: true, artifacts: 'npmLogs/*'
  }
}
