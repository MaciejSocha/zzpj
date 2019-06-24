package razdwatrzy.zzpj.controller.converters;

import org.springframework.core.convert.converter.Converter;
import razdwatrzy.zzpj.form.BonusForm;
import razdwatrzy.zzpj.model.Bonus;

public class BonusToBonusForm implements Converter<Bonus, BonusForm> {
    @Override
    public BonusForm convert(Bonus bonus) {
        BonusForm bonusForm = new BonusForm();
        bonusForm.setId(bonus.getId());
        bonusForm.setCampaignForm(new CampaignToCampaignForm().convert(bonus.getCampaign()));
        bonusForm.setTitle(bonus.getTitle());
        bonusForm.setTitle(bonus.getTitle());
        bonusForm.setDescription(bonus.getDescription());
        bonusForm.setPointsToGet(bonus.getPointsToGet());
        bonusForm.setIcon(bonus.getIcon());
        return bonusForm;
    }
}
