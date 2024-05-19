package com.example.s20.refresh

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews


class RefreshWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val views = RemoteViews(context.packageName, R.layout.refresh_widget)

        val intent = Intent(context, RefreshWidget::class.java)
        intent.setData(Uri.parse("96"))
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)

        val intent2 = Intent(context, RefreshWidget::class.java)
        intent2.setData(Uri.parse("120"))
        val pendingIntent2 = PendingIntent.getBroadcast(context, 0, intent2, 0)

        views.setOnClickPendingIntent(R.id.rate_96, pendingIntent)
        views.setOnClickPendingIntent(R.id.rate_120, pendingIntent2)

        for (appWidgetId in appWidgetIds) {
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        when (intent.data.toString()) {
            "96" -> set96HZ(context)
            "120" -> set120HZ(context)
        }

    }

}