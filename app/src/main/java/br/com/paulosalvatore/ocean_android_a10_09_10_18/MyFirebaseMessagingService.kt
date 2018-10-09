package br.com.paulosalvatore.ocean_android_a10_09_10_18

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
	companion object {
		const val TAG = "FMService"
	}

	override fun onNewToken(token: String?) {
		Log.i(TAG, token)

		FirebaseMessaging.getInstance().subscribeToTopic("MAIN")
	}

	override fun onMessageReceived(remoteMessage: RemoteMessage?) {
		val notification = remoteMessage?.notification

		Log.i(TAG, "FCM Message ID: ${remoteMessage?.messageId}")
		Log.i(TAG, "FCM Data Message: ${remoteMessage?.data}")
		Log.i(TAG, "FCM Notification Message: $notification")

		notification?.let {
			val titulo = it.title ?: ""
			val corpo = it.body ?: ""
			val dados = remoteMessage.data

			Log.i(TAG, "FCM Notification Title: $titulo")
			Log.i(TAG, "FCM Notification Body: $corpo")
			Log.i(TAG, "FCM Notification Data: $dados")

			// Criar a notificação
			NotificationCreation.create(this, titulo, corpo)
		}
	}
}
