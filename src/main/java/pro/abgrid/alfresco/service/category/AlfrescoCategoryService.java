package pro.abgrid.alfresco.service.category;

import pro.abgrid.alfresco.api.CategoriesApi;
import pro.abgrid.alfresco.dto.core.Category;
import pro.abgrid.alfresco.dto.core.CategoryBody;
import pro.abgrid.alfresco.dto.core.CategoryEntry;
import pro.abgrid.alfresco.dto.core.CategoryLinkBody;
import pro.abgrid.alfresco.dto.core.CategoryPaging;
import pro.abgrid.alfresco.model.PageSlice;
import pro.abgrid.alfresco.support.PagingExtractor;
import org.springframework.stereotype.Service;

/**
 * <p><strong>RU:</strong> Высокоуровневый Spring-сервис для сценариев «category» в Alfresco. Он служит прикладной границей над generated REST API: принимает более удобные параметры, скрывает технические детали HTTP/DTO там, где для них есть high-level модель, и оставляет доступ к серверному результату, когда это необходимо. Сервис предназначен для внедрения как обычный Spring bean в бизнес-сервисы приложения.</p>
 * <p><strong>EN:</strong> High-level Spring service for Alfresco category scenarios. It acts as an application boundary over the generated REST API: it accepts application-friendly parameters, hides HTTP/DTO plumbing where a high-level model exists, and still exposes server results when required. The service is intended to be injected as a regular Spring bean into application business services.</p>
 */
@Service
public class AlfrescoCategoryService {
    /** RU: Корневая категория Alfresco ({@code -root-}). EN: Alfresco root category ({@code -root-}). */
    public static final String ROOT = "-root-";

    private final CategoriesApi api;
    private final PagingExtractor paging;

        /**
     * <p><strong>RU:</strong> создаёт сервис и получает его зависимости через Spring DI; обычно этот конструктор не вызывается прикладным кодом напрямую.</p>
     * <p><strong>EN:</strong> creates the service with dependencies supplied by Spring DI; application code normally does not call this constructor directly.</p>
     *
     * @param api RU: зависимость `api`, используемая сервисом для выполнения операций Alfresco. EN: `api` dependency used by the service to perform Alfresco operations.
     * @param paging RU: зависимость `paging`, используемая сервисом для выполнения операций Alfresco. EN: `paging` dependency used by the service to perform Alfresco operations.
     */

    public AlfrescoCategoryService(CategoriesApi api, PagingExtractor paging) {
        this.api = api;
        this.paging = paging;
    }

        /**
     * <p><strong>RU:</strong> получает актуальное представление объекта из Alfresco; подходит для чтения его серверного состояния и метаданных.</p>
     * <p><strong>EN:</strong> retrieves the current Alfresco representation of the object for reading server-side state and metadata.</p>
     *
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public CategoryEntry get(String categoryId) {
        return api.getCategory(categoryId, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `create` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `create` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param parentCategoryId RU: значение параметра `parentCategoryId` для выполняемой операции. EN: value of `parentCategoryId` used by the operation.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public CategoryEntry create(String parentCategoryId, String name) {
        CategoryBody body = new CategoryBody();
        body.setName(requireText(name, "name"));
        return api.createCategory(requireText(parentCategoryId, "parentCategoryId"), null, null, body);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `createRoot` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `createRoot` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public CategoryEntry createRoot(String name) {
        return create(ROOT, name);
    }

        /**
     * <p><strong>RU:</strong> изменяет существующий объект Alfresco и возвращает состояние, подтверждённое сервером.</p>
     * <p><strong>EN:</strong> updates an existing Alfresco object and returns the server-confirmed state.</p>
     *
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     * @param name RU: имя создаваемого или изменяемого объекта. EN: name of the object being created or changed.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public CategoryEntry update(String categoryId, String name) {
        CategoryBody body = new CategoryBody();
        body.setName(requireText(name, "name"));
        return api.updateCategory(requireText(categoryId, "categoryId"), null, null, body);
    }

        /**
     * <p><strong>RU:</strong> удаляет соответствующий объект Alfresco; используйте метод, когда объект больше не должен быть доступен через репозиторий.</p>
     * <p><strong>EN:</strong> deletes the corresponding Alfresco object; use it when the object should no longer be available through the repository.</p>
     *
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     */

    public void delete(String categoryId) {
        api.deleteCategory(requireText(categoryId, "categoryId"));
    }

        /**
     * <p><strong>RU:</strong> передаёт generated-запрос напрямую в REST-клиент; предназначен для сценариев, которым недостаточно high-level API.</p>
     * <p><strong>EN:</strong> passes the generated request directly to the REST client; intended for cases not covered by the high-level API.</p>
     *
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public CategoryPaging subcategoriesRaw(String categoryId, int skip, int size) {
        return api.listSubcategories(requireText(categoryId, "categoryId"), null, skip, size, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `subcategories` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `subcategories` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Category> subcategories(String categoryId, int skip, int size) {
        return paging.extract(subcategoriesRaw(categoryId, skip, size).getList(), Category.class);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `roots` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `roots` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Category> roots(int skip, int size) {
        return subcategories(ROOT, skip, size);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `assign` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `assign` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     * @return RU: результат операции в модели high-level/generated API; конкретный тип отражает ответ Alfresco. EN: operation result represented by the high-level/generated API model; the concrete type reflects the Alfresco response.
     */

    public CategoryEntry assign(String nodeId, String categoryId) {
        CategoryLinkBody body = new CategoryLinkBody();
        body.setCategoryId(requireText(categoryId, "categoryId"));
        return api.createCategoryLinkForNode(requireText(nodeId, "nodeId"), null, null, body);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `unassign` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `unassign` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param categoryId RU: идентификатор категории. EN: category identifier.
     */

    public void unassign(String nodeId, String categoryId) {
        api.deleteCategoryLinkFromNode(requireText(nodeId, "nodeId"), requireText(categoryId, "categoryId"));
    }

        /**
     * <p><strong>RU:</strong> передаёт generated-запрос напрямую в REST-клиент; предназначен для сценариев, которым недостаточно high-level API.</p>
     * <p><strong>EN:</strong> passes the generated request directly to the REST client; intended for cases not covered by the high-level API.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public CategoryPaging categoriesForNodeRaw(String nodeId, int skip, int size) {
        return api.listCategoriesForNode(requireText(nodeId, "nodeId"), skip, size, null, null);
    }

        /**
     * <p><strong>RU:</strong> выполняет high-level операцию `categoriesForNode` над Alfresco и скрывает детали generated REST-клиента от прикладного кода.</p>
     * <p><strong>EN:</strong> performs the high-level `categoriesForNode` operation against Alfresco while hiding generated REST-client details from application code.</p>
     *
     * @param nodeId RU: идентификатор узла Alfresco. EN: Alfresco node identifier.
     * @param skip RU: значение параметра `skip` для выполняемой операции. EN: value of `skip` used by the operation.
     * @param size RU: максимальное количество элементов на странице. EN: maximum number of items per page.
     * @return RU: страница результатов с данными пагинации Alfresco. EN: result page including Alfresco paging information.
     */

    public PageSlice<Category> categoriesForNode(String nodeId, int skip, int size) {
        return paging.extract(categoriesForNodeRaw(nodeId, skip, size).getList(), Category.class);
    }

    private static String requireText(String value, String name) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(name + " must not be blank");
        return value;
    }
}
