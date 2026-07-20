
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject



def static "com.katalon.testcloud.FileExecutor.getFileDescriptor"(
    	String fileName	) {
    (new com.katalon.testcloud.FileExecutor()).getFileDescriptor(
        	fileName)
}


def static "com.katalon.testcloud.FileExecutor.exist"(
    	String fileName	) {
    (new com.katalon.testcloud.FileExecutor()).exist(
        	fileName)
}


def static "com.katalon.testcloud.FileExecutor.getFileContent"(
    	String fileName	) {
    (new com.katalon.testcloud.FileExecutor()).getFileContent(
        	fileName)
}


def static "com.katalon.testcloud.FileExecutor.uploadFileToWeb"(
    	TestObject to	
     , 	String filePath	) {
    (new com.katalon.testcloud.FileExecutor()).uploadFileToWeb(
        	to
         , 	filePath)
}


def static "com.katalon.testcloud.FileExecutor.pushFileToDevice"(
    	String destinationPath	
     , 	String localFilePath	) {
    (new com.katalon.testcloud.FileExecutor()).pushFileToDevice(
        	destinationPath
         , 	localFilePath)
}


def static "com.katalon.testcloud.GeolocationExecutor.setMobileGeoLocation"(
    	double latitude	
     , 	double longitude	
     , 	double altitude	) {
    (new com.katalon.testcloud.GeolocationExecutor()).setMobileGeoLocation(
        	latitude
         , 	longitude
         , 	altitude)
}


def static "com.katalon.testcloud.BiometricsAuthenticator.authenticatePass"() {
    (new com.katalon.testcloud.BiometricsAuthenticator()).authenticatePass()
}


def static "com.katalon.testcloud.BiometricsAuthenticator.authenticateFail"() {
    (new com.katalon.testcloud.BiometricsAuthenticator()).authenticateFail()
}


def static "com.katalon.testcloud.CameraImageInjectionExecutor.exist"(
    	String fileName	) {
    (new com.katalon.testcloud.CameraImageInjectionExecutor()).exist(
        	fileName)
}


def static "com.katalon.testcloud.CameraImageInjectionExecutor.injectImage"(
    	String fileName	) {
    (new com.katalon.testcloud.CameraImageInjectionExecutor()).injectImage(
        	fileName)
}


def static "com.katalon.testcloud.ThrottleNetworkExecutor.customNetworkProfile"(
    	int downloadSpeed	
     , 	int uploadSpeed	
     , 	int latency	) {
    (new com.katalon.testcloud.ThrottleNetworkExecutor()).customNetworkProfile(
        	downloadSpeed
         , 	uploadSpeed
         , 	latency)
}


def static "com.katalon.testcloud.ThrottleNetworkExecutor.setNetworkProfile"(
    	String condition	) {
    (new com.katalon.testcloud.ThrottleNetworkExecutor()).setNetworkProfile(
        	condition)
}
