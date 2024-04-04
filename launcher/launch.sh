
echo '-------------------------------------------------------------------------------------------'
echo '[NOTE] Launching application, this will fail if you did not build the project at least once'
echo '[NOTE] Remove the launcher folder to throw away local changes'
echo '-------------------------------------------------------------------------------------------'

java -jar target/dependency/org.apache.sling.feature.launcher.jar -f target/slingfeature-tmp/feature-app.json 
