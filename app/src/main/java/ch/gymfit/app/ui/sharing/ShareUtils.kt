package ch.gymfit.app.ui.sharing

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.FileProvider
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.FileOutputStream

object ShareUtils {
    /**
     * Erzeugt aus einer Compose-View eine Bitmap, speichert sie in cache/images und liefert die content:// URI via FileProvider zurück.
     */
    fun createShareImage(context: Context, composeView: ComposeView, fileName: String = "pr_share.png"): Uri? {
        return try {
            // Ensure view is measured & laid out
            composeView.measure(
                android.view.View.MeasureSpec.makeMeasureSpec(1080, android.view.View.MeasureSpec.EXACTLY),
                android.view.View.MeasureSpec.makeMeasureSpec(600, android.view.View.MeasureSpec.EXACTLY)
            )
            composeView.layout(0, 0, composeView.measuredWidth, composeView.measuredHeight)
            val bitmap = composeView.drawToBitmap()
            val cacheDir = File(context.cacheDir, "images")
            if (!cacheDir.exists()) cacheDir.mkdirs()
            // remove old files
            cacheDir.listFiles()?.forEach { if (it.name.endsWith(".png")) it.delete() }
            val outFile = File(cacheDir, fileName)
            val fos = FileOutputStream(outFile)
            bitmap.compress(Bitmap.CompressFormat.PNG, 95, fos)
            fos.flush()
            fos.close()
            FileProvider.getUriForFile(context, "ch.gymfit.app.fileprovider", outFile)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun shareImageUri(context: Context, imageUri: Uri?) {
        if (imageUri == null) return
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, imageUri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        context.startActivity(Intent.createChooser(intent, "Teilen"))
    }
}
