package gg.thenobrainguy.nobrainclient.utils;

import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomShaderLoader {

    private static final String SHADER_ZIP_NAME = "ComplementaryShaders_v4.3.2.zip"; // Shader zip file
    private static final String SHADER_TXT_NAME = "ComplementaryShaders_v4.3.2.zip.txt"; // Text file for the shader
    private static final File SHADERPACKS_DIR = new File(MinecraftClient.getInstance().runDirectory, "shaderpacks");

    public static void loadShaders() {
        // Ensure the shaderpacks directory exists
        if (!SHADERPACKS_DIR.exists()) {
            SHADERPACKS_DIR.mkdirs();
        }

        // Paths for the shader files
        Path shaderZipPath = new File(SHADERPACKS_DIR, SHADER_ZIP_NAME).toPath();
        Path shaderTxtPath = new File(SHADERPACKS_DIR, SHADER_TXT_NAME).toPath();

        // Check if the shader files already exist
        if (!Files.exists(shaderZipPath) || !Files.exists(shaderTxtPath)) {
            try {
                // If they don't exist, copy them from your resources
                if (!Files.exists(shaderZipPath)) {
                    Files.copy(CustomShaderLoader.class.getResourceAsStream("/assets/nobrainclient/shaders/" + SHADER_ZIP_NAME), shaderZipPath);
                }

                if (!Files.exists(shaderTxtPath)) {
                    Files.copy(CustomShaderLoader.class.getResourceAsStream("/assets/nobrainclient/shaders/" + SHADER_TXT_NAME), shaderTxtPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
