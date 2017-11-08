package com.rao.gcp.controller;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.rao.gcp.model.SimpleTranslation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/translate")
public class TranslateController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public SimpleTranslation translate(@RequestParam(value="query", defaultValue="Hei!") String query,
                                       @RequestParam(value="sourceLanguage", defaultValue="no") String sl,
                                       @RequestParam(value="targetLanguage", defaultValue="en") String tl) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Translates some text into Russian
        Translation translation =
                translate.translate(
                        query,
                        TranslateOption.sourceLanguage(sl),
                        TranslateOption.targetLanguage(tl));

        return new SimpleTranslation(counter.incrementAndGet(),
            translation.getTranslatedText());
    }

}
